import React, {Component} from 'react'
import {Link} from 'react-router-dom'
import {Button, FormGroup, Input, Row, Badge, CardText, Card, Container} from 'reactstrap';
import alertify from "alertifyjs";
import {withRouter} from 'react-router-dom';
import Logo from "../../images/e-nabiz-logo.jpg";

class Imzagiris extends Component {

    state = {
        loginValue: 0,
        password: '',
        loginType: 1
    }


    handleChange = event => {
        this.setState({loginValue: event.target.value})
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
                        if (data.data.canLogin) {
                            alertify.success("Başarılı !");
                            this.props.history.push("/home")

                        } else {
                            alertify.error("Giriş Başarısız !!");

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
                <Link to="/"><img src={Logo} width="600" height="150"/></Link>

                <form onSubmit={this.handleSubmit} style={{textAlign: 'center'}}>
                    <FormGroup>
                        <Input type="text"
                               placeHolder="Username Giriniz"
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
            </div>
        );
    }
}

export default withRouter(Imzagiris);