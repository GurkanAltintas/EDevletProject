import React, {Component} from 'react';
import {Col, Container, Row} from "reactstrap";
import Navibar from "../navbar/Navbar";
import Liste from "../navbar/Liste";

class Recete extends Component {
    render() {
        return (
            <div>
                <Row>
                    <Navibar/>
                </Row>
                <Row>
                    <Col xs="3"> <Liste/> </Col>
                    <Col xs="9">
                        <h1>Recete</h1>

                    </Col>
                </Row>


            </div>
        );
    }
}

export default Recete;