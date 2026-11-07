import React from 'react';
import ReactDOM from 'react-dom';

import { BrowserRouter as Router } from "react-router-dom";
import Routes from "./routes/routes";

import App from "./App";

import 'bootstrap/dist/css/bootstrap.min.css';

ReactDOM.render(
  <Router>
    <App>
      {Routes}
    </App>
  </Router>
  , document.getElementById('root'));
