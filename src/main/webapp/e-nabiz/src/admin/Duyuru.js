import React, {Component} from 'react';
import {Badge, Button, FormGroup, Input} from "reactstrap";
import { withRouter } from 'react-router-dom';
import alertify from "alertifyjs";
import AdminNav from "./AdminNav";

class Duyuru extends Component {

    state = {
        announcement: 0
    }


    handleChange = event => {
        this.setState({announcement: event.target.value})
    }

    handleSubmit = async event => {
        event.preventDefault()

        const requestOptions = {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(this.state)
        };

        fetch('http://localhost:8080/api/user/admin/saveAnnouncement', requestOptions)
            .then(response =>
                response.json().then(data => {

                    if(data.result.code=="0000")
                        alertify.success("Duyuru Yayınlandı !");
                        this.props.history.push("/adminProcess")
                    }
                )).catch(error => {
            console.log(error)
            alertify.error("Something gone wrong !");
        });

    }

    render() {
        return (
            <div>
                <AdminNav/>
                <form onSubmit={this.handleSubmit} style={{textAlign: 'center'}}>
                    <FormGroup>
                        <Input type="textarea"
                               placeHolder="Duyuru Giriniz"
                               name="TC Kimlik No" id="TC"
                               onChange={this.handleChange}

                        />
                    </FormGroup>
                    <Button color="success" type="submit" color="primary">Yayınla</Button>
                    <Badge color="primary">
                    </Badge>
                </form>
            </div>
        );
    }
}

export default withRouter(Duyuru);