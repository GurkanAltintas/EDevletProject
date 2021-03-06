import React, {Component} from 'react';
import {Button, Form, Col, FormGroup, Label, Input, FormText, Container} from 'reactstrap';
import logo from "../../images/edevlet-logo.png"
import logo2 from "../../images/e-nabiz-logo.jpg"
import alertify from "alertifyjs"
import {Link} from "react-router-dom";
import { withRouter } from 'react-router-dom';

class Register extends Component {

    state = {
        name: "",
        surname: "",
        identityNumber: "",
        username: "",
        password: "",
        mailAdress: "",
        phoneNumber: ""

    }
    handleChangeName = event => {
        this.setState({name: event.target.value})
    }
    handleChangeSurname = event => {
        this.setState({surname: event.target.value})
    }
    handleChangeidentityNumber = event => {
        this.setState({identityNumber: event.target.value})
    }
    handleChangeusername = event => {
        this.setState({username: event.target.value})
    }
    handleChangepassword = event => {
        this.setState({password: event.target.value})
    }
    handleChangemailAdress = event => {
        this.setState({mailAdress: event.target.value})
    }
    handleChangephoneNumber = event => {
        this.setState({phoneNumber: event.target.value})
    }

    submit = async event => {
        event.preventDefault()
        const requestOptions = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(this.state)
        };

        fetch('http://localhost:8080/api/user/saveUser', requestOptions)
            .then(response =>
                response.json().then(data => {
                    if(data.result.code==1000){
                        console.log('There was an error!');
                        alertify.error("Kayıt Olma Başarısız !")
                    }else{
                        alertify.success("Kayıt Olma Başarılı !")
                        this.props.history.push("/")
                    }


                    }
                ));
    }

    render() {
        return (
            <div>
                <Container>
                    <th><a href="https://www.turkiye.gov.tr/"><img src={logo} width="1000" height="150"/></a></th>
                    <th><img src={logo2} width="600" height="150"/></th>


                    <Form onSubmit={this.submit}>
                        <FormGroup>
                            <Label for="name">İsim</Label>
                            <Input type="text" name="name" id="name"
                                   onChange={this.handleChangeName} placeholder="İsim giriniz"/>
                        </FormGroup>
                        <FormGroup>
                            <Label for="surname">Soyisim</Label>
                            <Input type="text" name="surname" id="surname"
                                   onChange={this.handleChangeSurname} placeholder="Soyisim giriniz"/>
                        </FormGroup>
                        <FormGroup>
                            <Label for="id">T.C. Kimlik No</Label>
                            <Input type="text" name="id" id="id"
                                   onChange={this.handleChangeidentityNumber} placeholder="T.C. Kimlik No Giriniz"/>
                        </FormGroup>
                        <FormGroup>
                            <Label for="username">Kullanıcı adı</Label>
                            <Input type="text" name="username" id="username"
                                   onChange={this.handleChangeusername} placeholder="Kullanıcı adı giriniz"/>
                        </FormGroup>
                        <FormGroup>
                            <Label for="examplePassword">Şifre</Label>
                            <Input type="password" name="password" id="examplePassword"
                                   onChange={this.handleChangepassword} placeholder="Şifre giriniz"/>
                        </FormGroup>
                        <FormGroup>
                            <Label for="exampleEmail">E-mail</Label>
                            <Input type="email" name="email" id="exampleEmail"
                                   onChange={this.handleChangemailAdress} placeholder="E-mail giriniz"/>
                        </FormGroup>
                        <FormGroup>
                            <Label for="phone">Telefon Numarası</Label>
                            <Input type="text" name="phone" id="phone"
                                   onChange={this.handleChangephoneNumber} placeholder="Telefon Numarası Giriniz"/>
                        </FormGroup>

                        <Button color="primary">Kayıt Ol</Button>
                        <Button color="warning"><Link to="/">Giriş</Link></Button>


                    </Form>
                </Container>
            </div>

        );
    }
}

export default withRouter(Register);