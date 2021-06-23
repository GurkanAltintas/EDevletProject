import React, {Component} from 'react';
import {Badge, Button, Col, FormGroup, Input, Row} from "reactstrap";
import Navbar from "../navbar/Navbar";
import alertify from "alertifyjs";
import Liste from "../navbar/Liste";

class FeedbackHome extends Component {


    state = {
        feedback: 0
    }


    handleChange = event => {
        this.setState({feedback: event.target.value})
    }

    handleSubmit = async event => {
        event.preventDefault()

        const requestOptions = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(this.state)
        };

        fetch('http://localhost:8080/api/user/feedBack', requestOptions)
            .then(response =>
                response.json().then(data => {

                    console.log(data)
                        if (data.result.code == "0000"){
                            alertify.success("İstek Başarılı !");
                            this.props.history.push("/home")
                        }
                        else{
                            alertify.danger("İsteğiniz Gönderilemedi !");
                        }

                    }
                )).catch(error => {
            console.log(error)
            alertify.error("Something gone wrong !");
        });

    }

    render() {
        return (
            <div>
                <Row>
                    <Navbar/>
                    <Col xs="3">

                        <Liste/>
                    </Col>
                    <Col xs="9">
                        <form onSubmit={this.handleSubmit} style={{textAlign: 'center'}}>
                            <FormGroup>
                                <Input type="textarea"
                                       placeHolder="Şikayetinizi veya İsteklerinizi Yazabilirsiniz"
                                       name="TC Kimlik No" id="TC"
                                       onChange={this.handleChange}

                                />
                            </FormGroup>
                            <Button color="success" type="submit" color="primary">Gonder</Button>
                            <Badge color="primary">
                            </Badge>
                        </form>

                    </Col>


                </Row>

            </div>
        );
    }
}

export default FeedbackHome;