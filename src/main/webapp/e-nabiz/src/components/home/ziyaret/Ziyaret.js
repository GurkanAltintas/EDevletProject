import React, {Component} from 'react';
import {Col, Container, Row, Table} from "reactstrap";
import Navibar from "../navbar/Navbar";
import Liste from "../navbar/Liste";
import alertify from "alertifyjs";
import {
    Card, CardImg, CardText, CardBody,
    CardTitle, CardSubtitle, Button
} from 'reactstrap';
class Ziyaret extends Component {
    state = {
        visit: []
    }

    componentDidMount() {

        let object = {userInfo: "11999637634"}
        const requestOptions = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(object)
        };

        fetch('http://localhost:8080/api/user/fetchVizits', requestOptions)
            .then(response => response.json()).then(data => {
            this.setState({visit: data.data})
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
                        {
                            this.state.visit.map(item => (


                                <tr key={item.id}>
                                    <Card>
                                        <CardBody>
                                            <h6 className="card-subtitle mb-2 text-muted">{item.vizitDate}</h6>
                                            <CardTitle tag="h5">{item.hospitalName}</CardTitle>
                                            <h6 className="card-subtitle mb-2 text-muted">Klinik Adı:{item.clinicName}</h6>
                                            <h6 className="card-subtitle mb-2 text-muted">Hekim Adı:{item.doctorName}</h6>
                                            <h6 className="card-subtitle mb-2 text-muted">Hastane Takip No:{item.trackingNumber}</h6>
                                        </CardBody>
                                    </Card>

                                </tr>
                            ))
                        }

                    </Col>
                </Row>

            </div>
        );
    }
}

export default Ziyaret;