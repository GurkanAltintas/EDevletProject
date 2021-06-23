import React, {Component} from 'react';
import {Col, Container, Row, Table} from "reactstrap";
import Navibar from "../navbar/Navbar";
import Liste from "../navbar/Liste";
import alertify from "alertifyjs";

class Rapor extends Component {

    state = {
        rapor: []
    }
    componentDidMount() {

        let object = {userInfo: "11999637634"}
        const requestOptions = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(object)
        };

        fetch('http://localhost:8080/api/user/fetchReports', requestOptions)
            .then(response => response.json()).then(data => {
            this.setState({rapor: data.data})
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
                                <th>Rapor No</th>
                                <th>Rapor Takip No</th>
                                <th>Rapor Türü</th>
                                <th>Başlangıç Tarihi</th>
                                <th>Bitiş Tarihi</th>
                                <th>Tanı</th>
                            </tr>
                            </thead>
                            <tbody>
                            {
                                this.state.rapor.map(item=>(
                                    <tr>
                                        <th scope="row">{item.reportDate}</th>
                                        <td>{item.reportNumber}</td>
                                        <td>{item.reportTrackingNumber}</td>
                                        <td>{item.reportType}</td>
                                        <td>{item.startDate}</td>
                                        <td>{item.endDate}</td>
                                        <td>{item.diagnosis}</td>
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

export default Rapor;