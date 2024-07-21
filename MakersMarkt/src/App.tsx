import React, { useState } from 'react'
import './App.css'
import {Route, Router} from 'react-router-dom';
import ProductOndernemer from ./pages/ProductOndernemer/ProductOndernemerPages

function Switch(props: { children: ReactNode }) {
    return null;
}

function App() {
    return (
        <Router>
            <Switch>
                <Route path="/ProductOndernemer/:id" component={ProductOndernemer} />
            </Switch>
        </Router>
    );
}

export default App;