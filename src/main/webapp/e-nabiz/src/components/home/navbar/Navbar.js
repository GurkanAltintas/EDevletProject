import React, {Component} from 'react';
import {
    Collapse,
    Navbar,
    NavbarToggler,
    NavbarBrand,
    Nav,
    NavItem,
    NavLink,
    UncontrolledDropdown,
    DropdownToggle,
    DropdownMenu,
    DropdownItem,
    NavbarText
} from 'reactstrap';
import logo2 from "../../../images/ee.png"
import logo from "../../../images/aaa.png"

class Navibar extends Component {
    render() {
        return (
            <div>
                <Navbar color="light" light expand="md">
                    <NavbarBrand href="/home"><img src={logo2} width="150" height="50"/></NavbarBrand>
                    <NavbarToggler />
                    <Collapse isOpen={false} navbar>
                        <Nav className="mr-auto" navbar>
                            <NavItem>
                                <NavLink href="/components/">Components</NavLink>
                            </NavItem>
                            <NavItem>
                                <NavLink href="https://github.com/reactstrap/reactstrap">GitHub</NavLink>
                            </NavItem>
                            <UncontrolledDropdown nav inNavbar>
                                <DropdownToggle nav caret>
                                    Options
                                </DropdownToggle>
                                <DropdownMenu right>
                                    <DropdownItem>
                                        Option 1
                                    </DropdownItem>
                                    <DropdownItem>
                                        Option 2
                                    </DropdownItem>
                                    <DropdownItem divider />
                                    <DropdownItem>
                                        Reset
                                    </DropdownItem>
                                </DropdownMenu>
                            </UncontrolledDropdown>
                            <NavItem>
                                <NavLink href="/home/duyurular">Duyurularım</NavLink>
                            </NavItem>
                        </Nav>
                        <NavbarText>Simple Text</NavbarText>
                    </Collapse>
                    <NavbarBrand href="/"><img src={logo} width="100" height="50"/></NavbarBrand>
                </Navbar>

            </div>
        );
    }
}

export default Navibar;