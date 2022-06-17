import React, { useState } from 'react';
import { gql, useMutation } from '@apollo/client';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import PersonOutlineOutlinedIcon from '@mui/icons-material/PersonOutlineOutlined';
import EmailOutlinedIcon from '@mui/icons-material/EmailOutlined';
import VisibilityOutlinedIcon from '@mui/icons-material/VisibilityOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { styled, useTheme, createTheme, ThemeProvider } from '@mui/material/styles';
import { InputAdornment } from '@material-ui/core';
import {useNavigate} from 'react-router-dom';
import Navbar from './Navbar';
import MuiDrawer from '@mui/material/Drawer';
import InboxIcon from '@mui/icons-material/MoveToInbox';
import MailIcon from '@mui/icons-material/Mail';

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

const Drawer = styled(MuiDrawer)(
  ({ theme }) => ({
  width: 240,
  flexShrink: 0,
  whiteSpace: 'nowrap',
  boxSizing: 'border-box',
}));

const Main = () => {

  // grab data from backend for all componenets & pass props from Navbar to Main

 return(
   <Grid container spacing={0}>
     <Grid item xs={0}>
     <Navbar />
     </Grid>
   </Grid>
 );
}

export default Main;
