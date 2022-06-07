import React, { useState } from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faEnvelope, faLock } from '@fortawesome/free-solid-svg-icons'
import {useNavigate} from 'react-router-dom'


const Login = () => {
    const [data, setData] = useState({
        email: '',
        password: '', 
        error: null,
        loading: false,
    });

    const navigate = useNavigate(); 
    const {email, password, error, loading} = data;

    const handleChange = e => {
        setData({...data, [e.target.name]: e.target.value});
    };

    const handleSubmit = async e => {
        e.preventDefault();
        setData({...data, error: null, loading: true});
        if (!email || !password){
            setData({...data, error: "Please fill out all input fields. "})
        }
        try {
            //method for connecting to back end
        } catch (err) {
            setData({...data, error: err.message, loading: false})
        } 
    };
    
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
                                        <div className='input-group-prepend'>
                                            <span className="input-group-text">
                                            <FontAwesomeIcon icon={faEnvelope}/>
                                            </span>
                                            <input placeholder='Email' name='email' className='form-control' type="email" />
                                        </div>
                                    </div>
                                    <div className="form-group">
                                        <label>Password</label>
                                        <div className='input-group-prepend'>
                                            <span className="input-group-text">
                                            <FontAwesomeIcon icon={faLock}/>
                                            </span>
                                            <input placeholder='Password' name='password' className='form-control' type="password" />
                                        </div>
                                    </div>
                                    <button className='btn btn-success'>Login</button>
                                    <br />
                                    <a href="reset">Forgot Password</a> <br />
                                    <a href="signup">Create new account</a>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
        );
    }


export default Login;