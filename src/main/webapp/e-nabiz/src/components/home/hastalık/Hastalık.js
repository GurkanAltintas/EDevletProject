import React, {Component} from 'react';
import {Col, Container, Row, Table} from "reactstrap";
import Navibar from "../navbar/Navbar";
import Liste from "../navbar/Liste";
import alertify from "alertifyjs";

class Hastalık extends Component {

    state = {
        hastalık: []
    }
    componentDidMount() {

        let object = {userInfo: "11999637634"}
        const requestOptions = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(object)
        };

        fetch('http://localhost:8080/api/user/fetchDiseases', requestOptions)
            .then(response => response.json()).then(data => {
            this.setState({hastalık: data.data})
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
                                <th>Tanı</th>
                                <th>Klinik</th>
                                <th>Hekim</th>
                            </tr>
                            </thead>
                            <tbody>
                            {
                                this.state.hastalık.map(item=>(
                                    <tr>
                                        <th scope="row">{item.diagnosisDate}</th>
                                        <td>{item.diagnosis}</td>
                                        <td>{item.clinic}</td>
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

export default Hastalık;