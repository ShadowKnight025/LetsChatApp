import React, { useState } from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
//import { FontAwesomeIcon } from '@fontawesome/fortawesome'
//import { faEnvelope, faLock } from '@fortawesome/free-solid-svg-icons'
import {useNavigate} from 'react-router-dom'
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import EmailOutlinedIcon from '@mui/icons-material/EmailOutlined';
import VisibilityOutlinedIcon from '@mui/icons-material/VisibilityOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { InputAdornment } from '@material-ui/core';
import axios from 'axios';

function Copyright(props) {
    return (
      <Typography variant="body2" color="text.secondary" align="center" {...props}>
        {'All rights reserved to Lets Chat '}
        {' '}
        {new Date().getFullYear()}
        {'.'}
      </Typography>
    );
  }

const theme = createTheme();

const Login = () => {
    const [data, setData] = useState({
        username: '',
        password: '',
        error: null,
        loading: false,
    });

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const navigate = useNavigate();

    const {/*username, password,*/ error, loading} = data;

    const handleChange = e => {
        //console.log(setData({...data, [e.target.name]: e.target.value}));
        //console.log(setUsername({username}))
    };

    const handleSubmit = async e => {
        e.preventDefault();
        setData({...data, error: null, loading: true});
        if (!username || !password){
            setData({...data, error: "Please fill out all input fields. "})
        }
        try {
          const params = new URLSearchParams();
          params.append('username', username);
          params.append('password', password);

          axios.post(`/login`, params)
            .then( res => {
              console.log(res);
            })
          } catch (err) {
            setData({...data, error: err.message, loading: false})
          }
        };

        return (
           <ThemeProvider theme={theme}>
            <Container component="main" maxWidth="xs">
              <CssBaseline />
              <Box
                sx={{
                  marginTop: 8,
                  display: 'flex',
                  flexDirection: 'column',
                  alignItems: 'center',
                }}
              >
                <Avatar sx={{ m: 1, bgcolor: '#b71c1c' }}>
                  <LockOutlinedIcon />
                </Avatar>
                <Typography component="h1" variant="h5">
                  Login
                </Typography>

                <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
                <Grid container spacing={2}>
                    <Grid item xs={12}>
                      <TextField
                        required
                        fullWidth
                        id="username"
                        label="Username"
                        name="username"
                        onChange={(e) => setUsername(e.target.value)}
                        InputProps={{
                          endAdornment: (
                            <InputAdornment position="end">
                              <EmailOutlinedIcon />
                            </InputAdornment>
                          ),
                        }}
                      />
                    </Grid>
                    <Grid item xs={12}>
                      <TextField
                        required
                        fullWidth
                        id="password"
                        label="Password"
                        name="password"
                        type="password"
                        onChange={(e) => setPassword(e.target.value)}
                        InputProps={{
                          endAdornment: (
                            <InputAdornment position="end">
                              <VisibilityOutlinedIcon />
                            </InputAdornment>
                          ),
                        }}
                      />
                    </Grid>
                  </Grid>
                  {error ? <p className='error'>{error}</p>: null}
                  <Button
                    type="submit"
                    fullWidth
                    variant="contained"
                    disabled={loading}
                    sx={{ mt: 2, mb: 2, bgcolor: '#b71c1c',
                    '&:hover': {
                      backgroundColor: '#E75A22',
                      color: 'black',
                      boxShadow: 3,
                  },
                  }}
                  >
                    {loading ? 'Logging In...': 'Login'}
                  </Button>
                  <Grid container justifyContent="flex-end">
                    <Grid item>
                      <Link href="/reset" variant="body2" align='right'>
                        Forgot Password?
                      </Link>
                    </Grid>
                  </Grid>
                  <Grid container justifyContent="flex-end">
                    <Grid item>
                      <Link href="/signup" variant="body2" align='right'>
                        Create new Account
                      </Link>
                    </Grid>
                  </Grid>
                </Box>
              </Box>
              <Copyright sx={{ mt: 5 }} />
            </Container>
          </ThemeProvider>
        );
      }


export default Login;
