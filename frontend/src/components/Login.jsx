import React, { Component } from 'react';
import {Button, Col, Container, Form, Row} from "reactstrap";
import 'bootstrap/dist/css/bootstrap.min.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEnvelope, faUser, faLock } from '@fortawesome/free-solid-svg-icons';

class Login extends Component {
    constructor(props) {
        super(props);
        
    }
    
    render() {
        return (
            <div>
                <div className="container">
                    <div className="row">
                        <div className='card col-md-6 offset-md-3 offset-md-3'>
                            <h3 className="text-center">Login</h3>
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label>Email</label>
                                        <input placeholder='Email' name='email' className='form-control' type="email" />
                                    </div>
                                    <div className="form-group">
                                        <label>Password</label>
                                        <input placeholder='Password' name='password' className='form-control' type="password" />
                                    </div>
                                    <button className='btn btn-success'>Login</button>
                                    <button className='btn btn-danger' onClick={this.cancel} style={{marginLeft:"10px"}}>Forgot Password</button>
                                    <br />
                                    <a href="signup">Create new account</a>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
        );
    }
}

export default Login;