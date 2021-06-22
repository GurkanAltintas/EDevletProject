import React, {Component} from 'react';
import {Form, FormGroup, Label, Input, Container} from "reactstrap";
import logo from "../../images/edevlet-logo.png";
import logo2 from "../../images/imzagirisi.png"
import {Link} from "react-router-dom";
class KutleEndeksi extends Component {


    state = {
        boy: 0,
        kutle: 0,
        result: 0
    }
    handleChange = (event) => {
        this.setState({boy: event.target.value});
    }
    handleChangeKilo = (event) => {
        this.setState({kilo: event.target.value});
    }

    handleSubmit(event) {
        event.preventDefault();
    }

    calculate = () => {

        this.setState({result:this.state.kilo/(this.state.boy*this.state.boy/10000)})

    }

    render() {
        return (
            <div>
                <Container>
                    <Label><h5 > Vücut Kitle İndeksi</h5></Label>
                <Form onSubmit={this.handleSubmit}>
                    <FormGroup>
                        <Label for="boy">Boy</Label>
                        <Input type="number"   onChange={this.handleChange} id="boy" placeholder="Boy giriniz" />
                    </FormGroup>
                    <FormGroup>
                        <Label for="kilo">Boy</Label>
                        <Input type="number"  value={this.state.kilo} onChange={this.handleChangeKilo} id="kilo" placeholder="Kilo giriniz" />
                    </FormGroup>
                    <FormGroup>
                        <Label for="indx">Kütle İndeksi : {this.state.result}</Label>
                    </FormGroup>


                    <input type="submit" onClick={this.calculate} value="Hesapla"/>
                </Form>
                </Container>

                <Link to="imza"><img src={logo2} width="350" height="250"/></Link>

            </div>
        );
    }
}

export default KutleEndeksi;