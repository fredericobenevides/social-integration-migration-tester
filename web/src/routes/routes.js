import React from 'react';
import { Route, Switch } from 'react-router-dom';

import ServicosIndex from "../pages/ServicosIndex";
import ServicoNew from "../pages/ServicoNew";
import ServicoEdit from "../pages/ServicoEdit";

const routes = (
  <Switch>
    <Route exact path="/" component={ServicosIndex}/>
    <Route path="/new" component={ServicoNew}/>
    <Route path="/:id/edit" component={ServicoEdit}/>
  </Switch>
);

export default routes;