import React, {Component} from 'react';
import {Container, Row} from "reactstrap";
import AdminNav from "./AdminNav";

class AdminProcess extends Component {

    state={
        duyuru:false,
        kullanıcı:false
    }
    render() {
        return (
            <div>
                <Container>
                    <Row >
                        <AdminNav state={this.state}/>

                    </Row>
                    <Row>

                        <h1>eheuhuhu</h1>
                    </Row>
                </Container>


            </div>
        );
    }
}

export default AdminProcess;