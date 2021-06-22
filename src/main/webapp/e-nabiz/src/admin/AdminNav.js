import React, {Component} from 'react';
import { Collapse, Navbar, NavbarToggler, NavbarBrand, Nav, NavItem, NavLink } from 'reactstrap';
class AdminNav extends Component {
    render() {
        return (
            <div>
                <div>
                    <Navbar color="faded" light>
                        <NavbarBrand href="/" className="mr-auto">E-Nabız Giriş</NavbarBrand>
                        <NavbarBrand href="/duyuru" className="mr-auto">Duyuru yap</NavbarBrand>
                        <NavbarBrand href="/users" className="mr-auto">Kullanıcılar</NavbarBrand>
                        <NavbarToggler  className="mr-2"  />

                    </Navbar>

                </div>

            </div>
        );
    }
}

export default AdminNav;