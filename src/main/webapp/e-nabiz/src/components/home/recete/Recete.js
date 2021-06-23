import React, {Component} from 'react';
import {Col, Container, Row} from "reactstrap";
import Navibar from "../navbar/Navbar";
import Liste from "../navbar/Liste";
import alertify from "alertifyjs";

import { Table } from 'reactstrap';
class Recete extends Component {
    state = {
        recete: []
    }
    componentDidMount() {

        let object = {userInfo: "11999637634"}
        const requestOptions = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(object)
        };

        fetch('http://localhost:8080/api/user/fetchRecipes', requestOptions)
            .then(response => response.json()).then(data => {
            this.setState({recete: data.data})
        })
            .catch(error => {
                console.log(error)
                alertify.error("Something gone wrong !");
            });
    }
    render() {
        return (
            <div>
                <Row>
                    <Navibar/>
                </Row>
                <Row>
                    <Col xs="3"> <Liste/> </Col>
                    <Col xs="9">
                        <Table>
                            <thead>
                            <tr>
                                <th>Tarih</th>
                                <th>Reçete No</th>
                                <th>Reçete Türü</th>
                                <th>Hekim</th>
                            </tr>
                            </thead>
                            <tbody>
                            {
                                this.state.recete.map(item=>(
                                    <tr>
                                        <th scope="row">{item.recepiDate}</th>
                                        <td>{item.recepiNumber}</td>
                                        <td>{item.recepiType}</td>
                                        <td>{item.doctor}</td>
                                    </tr>)
                                )
                            }
                            </tbody>
                        </Table>

                    </Col>
                </Row>


            </div>
        );
    }
}

export default Recete;