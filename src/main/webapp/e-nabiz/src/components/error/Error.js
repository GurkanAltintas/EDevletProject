import React, {Component} from 'react';
import hata from "../../images/error.png"
import {Link} from "react-router-dom";
class Error extends Component {
    render() {
        return (
            <div>
                <Link to="/home"> <img src={hata}/> </Link>
            </div>
        );
    }
}

export default Error;