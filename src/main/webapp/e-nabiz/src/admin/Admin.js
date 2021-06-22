import React, {Component} from 'react';
import alertify from "alertifyjs";
import { Button, FormGroup, Input} from "reactstrap";
import logo from "../images/admin.png"

import { withRouter } from 'react-router-dom';
class Admin extends Component {

    state = {
        loginValue: 0,
        password: ''
    }
    handleChange = event => {
        this.setState({loginValue: event.target.value})
    }
    handleChangeP = event => {
        this.setState({password: event.target.value})
    }
    handleSubmit = async event => {
        event.preventDefault()

        if(this.state.loginValue=="admin" && this.state.password=="admin"){
            alertify.success("Başarılı !");
            this.props.history.push("/adminProcess")
        }else{
            alertify.error("id veya şifre yanlış")
        }

    }

    render() {
        return (
            <div>
                <img src={logo} width="450" height="350"/>
                <form onSubmit={this.handleSubmit} style={{textAlign: 'center'}}>
                    <FormGroup>
                        <Input type="text"
                               placeHolder="id"
                               name="TC Kimlik No" id="TC"
                               onChange={this.handleChange}

                        />
                    </FormGroup>
                    <FormGroup>
                        <Input type="password"
                               placeHolder="password"
                               name="Sifre"
                               id="sifre"
                               onChange={this.handleChangeP}

                        />
                    </FormGroup>
                    <Button color="success" type="submit" color="primary">Giriş</Button>

                </form>

            </div>
        );
    }
}

export default withRouter(Admin);