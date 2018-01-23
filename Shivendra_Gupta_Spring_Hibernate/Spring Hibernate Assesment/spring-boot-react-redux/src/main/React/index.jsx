import React from 'react'
import { render } from 'react-dom'
import { Route, IndexRoute ,browserHistory} from 'react-router'
import { Router } from 'react-router'

import { Provider } from 'react-redux'

import {  combineReducers, applyMiddleware } from 'redux'

import store from './store'


import Products from 'components/ProductsComponent'
import Product from 'components/ProductComponent'
import Product1 from 'components/ProductComponent1'
import App from 'components/MainScript'
import NewProduct from 'components/NewProductComponent'
import ById from 'components/SearchById'
import ByName from 'components/SearchByName'
import EditProduct1 from 'components/EditProductComponent1'


render(
    <Provider store={store}>
         <Router history={browserHistory} >
         <Route path='/' component={App}>
         <IndexRoute component={Products}></IndexRoute>
         <Route path='/view/:id' component={Product}></Route>
          <Route path='/view1/:name' component={Product1}></Route>
         <Route path='/newProduct' component={NewProduct}></Route>
         <Route path='/searchName' component={ByName}></Route>
         <Route path='/searchId' component={ById}></Route>
         <Route path='/editProduct1/:id' component={EditProduct1}></Route>
         </Route>
         </Router>
    </Provider>,
    document.getElementById("content")
)