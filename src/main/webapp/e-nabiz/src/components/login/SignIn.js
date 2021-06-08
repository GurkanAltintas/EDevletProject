import React, {Component} from 'react'
import {Link} from 'react-router-dom'
import {Button, Form, FormGroup, Label, Input, FormText} from 'reactstrap';


class SignIn extends Component {

    state = {
        tc: 0,
        password: '',
    }


    handleChange = event => {
        this.setState({tc: event.target.value })
    }
    handleChangeP = event => {
        this.setState({password: event.target.value })
    }

    handleSubmit = async event => {
        event.preventDefault()

        {
            console.log(this.state.password)
        }
    }


    render() {
        return (
            <div>

                <form onSubmit={this.handleSubmit} style={{textAlign: 'center'}}>
                    <FormGroup>
                        <Input type="number"
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

                    <Link to="/forgot" className="btn btn-lg"> Şifremi Unuttum      </Link>
                </form>

            </div>
        );
    }
}

export default SignIn;