import React, {Component} from 'react'
import {Link} from 'react-router-dom'
import {Button, FormGroup, Input, Row, Badge, CardText, Card, Container} from 'reactstrap';
import alertify from "alertifyjs";
import { withRouter } from 'react-router-dom';
import {Redirect} from "react-router";
import {useHistory} from "react-router-dom"


class SignIn extends Component {

    state = {
        username: 0,
        password: ''
    }



    handleChange = event => {
        this.setState({username: event.target.value})
    }
    handleChangeP = event => {
        this.setState({password: event.target.value})
    }

    handleSubmit = async event => {
        event.preventDefault()

        const requestOptions = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(this.state)
        };

        fetch('http://localhost:8080/api/user/login', requestOptions)
            .then(response =>
                response.json().then(data => {
                    if(data.data.canLogin){
                        alertify.success("Başarılı !");
                        this.props.history.push("/home")

                    }else{
                        alertify.error("Giriş Başarısız");

                    }

                    }
                )).catch(error=>{
                    console.log(error)
                    alertify.error("Something gone wrong !");
        });

    }
    render() {
        return (
            <div>

                <form onSubmit={this.handleSubmit} style={{textAlign: 'center'}}>
                    <FormGroup>
                        <Input type="text"
                               placeHolder="T.C. Kimlik Numarası Giriniz"
                               name="TC Kimlik No" id="TC"
                               onChange={this.handleChange}

                        />
                    </FormGroup>
                    <FormGroup>
                        <Input type="password"
                               placeHolder="e-Nabız şifresini giriniz"
                               name="Sifre"
                               id="sifre"
                               onChange={this.handleChangeP}

                        />
                    </FormGroup>
                    <Button color="success" type="submit" color="primary">Giriş</Button>
                    <Badge color="primary">
                        <Link to="/forgot" className="btn btn-lg"> Şifremi Unuttum </Link>
                    </Badge>
                </form>
                <Row >

                </Row>
                <Container >


                <Row >
                    <p className="text-muted">
                        İlk kez e-Nabız kullanıcısı olacak kişiler e-Devlet
                        <a href="https://www.turkiye.gov.tr/" target="_blank"> (www.turkiye.gov.tr)</a> üzerinden e-Nabız’a giriş yaparak
                        profil ayarları üzerinden e-Nabız şifresi oluşturmalı
                        ya da kendi Aile Hekimine başvurarak
                        e-Nabız için geçici şifre edinmelidir.
                </p>
                    <div class="devider">________________________________________________________</div>
                    <Row >
                        <Link to="/register" >
                            <Button  color="danger">E-Devlet Üzerinden Kayıt Ol</Button>
                        </Link>
                    </Row>
                </Row >
                </Container>
                <p className="text-success">
                    <a href="https://enabiz.gov.tr/Yardim/Index" target="_blank"> e-Devlet Üzerinden Nasıl Kayıt Olurum? </a>
                </p>



            </div>
        );
    }
}

export default withRouter(SignIn);