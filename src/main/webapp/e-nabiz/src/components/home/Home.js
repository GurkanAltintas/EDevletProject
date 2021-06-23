import React, {Component} from 'react';
import Navibar from "./navbar/Navbar";
import {Col, Container, Row} from "reactstrap";
import Liste from "./navbar/Liste"
class Home extends Component {
    render() {
        return (
            <Container>
                    <Row>
                        <Navibar/>
                    </Row>
                    <Row>
                        <Col xs="3"> <Liste/> </Col>
                        <Col xs="9"></Col>
                    </Row>



            </Container>
        );
    }
}

export default Home;