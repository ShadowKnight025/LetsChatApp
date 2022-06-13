import React, { useState } from 'react';
import { gql, useMutation } from '@apollo/client';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import PersonOutlineOutlinedIcon from '@mui/icons-material/PersonOutlineOutlined';
import EmailOutlinedIcon from '@mui/icons-material/EmailOutlined';
import VisibilityOutlinedIcon from '@mui/icons-material/VisibilityOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { InputAdornment } from '@material-ui/core';
import {useNavigate} from 'react-router-dom'

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

const registerUser = gql`
  mutation addUserMutation(
      $username: String!
      $password: String!
      $emailaddress: String!
  ){
      addUser(username: $username, password: $password, emailaddress: $emailaddress){
          username
      }
  }
`

const Signup = () => {
    const [data, setData] = useState({
      email: '',
      userName: '',
      password: '', 
      confirmPassword: '',
      error: null,
      loading: false,
  });
  const navigate = useNavigate(); 

  const {email, userName, password, confirmPassword, error, loading} = data;
  
    const [adduser] = useMutation(registerUser, {
        variables:{
            username: data.userName, 
            password: data.password, 
            emailaddress: data.email
        }
       }); 

    const handleChange = e => {
        setData({...data, [e.target.name]: e.target.value});
    };

    const handleSubmit = async e => {
        e.preventDefault();
        setData({...data, error: null, loading: true});
        if (!userName || !email || !password || !confirmPassword){
            setData({...data, error: "Please fill out all input fields. "})
        }
        else if(password !== confirmPassword){
            setData({...data, error: "Passwords do not match"})
        }
        try 
        {
            adduser();
        } 
        catch (err) 
        {
            //add error handling
        }
    };
        return(
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
                        Sign up
                    </Typography>

                    <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
                    <Grid container spacing={2}>
                        <Grid item xs={12}>
                            <TextField
                            required
                            fullWidth
                            id="email"
                            label="Email Address"
                            name="email"
                            type="email"
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
                            id="username"
                            label="Username"
                            name="username"
                            InputProps={{
                                endAdornment: (
                                <InputAdornment position="end">
                                    <PersonOutlineOutlinedIcon />
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
                            InputProps={{
                                endAdornment: (
                                <InputAdornment position="end">
                                    <VisibilityOutlinedIcon />
                                </InputAdornment>
                                ),
                            }}
                            />
                        </Grid>
                        <Grid item xs={12}>
                            <TextField
                            required
                            fullWidth
                            name="confirmPassword"
                            label="Confirm Password"
                            type="password"
                            id="confirmPassword"
                            autoComplete="new-password"
                            InputProps={{
                                endAdornment: (
                                <InputAdornment position="end">
                                    <VisibilityOutlinedIcon />
                                </InputAdornment>
                                ),
                            }}
                            />
                        </Grid>
                        {error ? <p className='error'>{error}</p>: null}  
                        </Grid>
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
                        {loading ? 'Creating User...': 'Sign up'}
                        </Button>
                        <Grid container justifyContent="flex-end">
                        <Grid item>
                            <Link href="/login" variant="body2">
                            Already have an account? Sign in
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
export default Signup;