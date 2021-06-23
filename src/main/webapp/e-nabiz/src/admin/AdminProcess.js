import React, {Component} from 'react';
import {Col, Container, Row} from "reactstrap";
import AdminNav from "./AdminNav";
import Duyuru from "./Duyuru";
import GetUser from "./GetUser";

class AdminProcess extends Component {


    changeDuyuru = () => {
        this.setState({duyuru: true})
    }

    render() {
        return (
            <div>
                <Container>
                    <Row>
                        <AdminNav/>

                    </Row>
                    <Row>


                    </Row>
                </Container>


            </div>
        );
    }
}

export default AdminProcess;