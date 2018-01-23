import products from './ProductsReducer';
import {combineReducers} from 'redux';

var rootReducer=combineReducers({
    products
})

export default rootReducer;