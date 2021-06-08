import React, {Component} from 'react';
import KutleEndeksi from "../endekskutle/KutleEndeksi";
import {Container, Col, Row} from "reactstrap";
import SignIn from "./SignIn";
import Logo from "../../images/e-nabiz-logo.jpg";

class Login extends Component {
    render() {
        return (
            <div>
                <Container>
                       <Row>
                        <Col xs="4">
                            <img src={Logo}/>
                            <SignIn/> </Col>
                        <Col xs="4"> <KutleEndeksi/> </Col>
                </Row>
                </Container>


            </div>
        );
    }
}

export default Login;