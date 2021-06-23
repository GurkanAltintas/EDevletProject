import React, {Component} from 'react';
import ziyaretLogo from "../../../images/ziyaret.png"
import geriBildirim from "../../../images/geribildirim.png"
import hasta from "../../../images/hasta.png"
import rapor from "../../../images/rapor.png"
import recete from "../../../images/recete.png"

class Liste extends Component {
    render() {
        return (
            <div>
                <ul className="nav flex-column">
                    <li className="nav-item">
                        <a className="nav-link active" href="/ziyaret"><img src={ziyaretLogo}/>Ziyaretlerim</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="/recete"><img src={recete}/>Reçetelerim</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="/rapor"><img src={rapor}/>Raporlarım</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="/hastalik"><img src={hasta}/>Hastalıklarım</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="/geribildirim"><img src={geriBildirim}/>Geri Bildirim</a>
                    </li>
                </ul>
            </div>
        );
    }
}

export default Liste;