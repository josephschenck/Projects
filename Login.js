import React, { Component } from 'react';
import ReactDOM from 'react-dom';

class Login extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            email: '',
            password: ''
        };

        this.postData = this.postData.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);

    }

    handleChange(event) {
        this.setState({ [event.target.name]: event.target.value });
        console.log(event.target.value);
    }

    handleSubmit(event) {
        console.log("submit being called");
        this.postData('api/users/login', { email: 'admin@envoc.com', password: 'password' })
            .then(data => console.log(data));
        event.preventDefault();

    }

    postData(url, data) {
        console.log("postData being called");
        return fetch(url, { method: 'POST',
            body: JSON.stringify(data),
            headers: {
                'content-type': 'application/json'
            },
        })
            .then(response => {
                if (response.status === 200) {
                    console.log("response status");
                    return response.json();
                } else {
                    throw new Error('Something went wrong on api server!');
                }
            })
            .then(response => {
                console.log(response);
                // ...
            }).catch(error => {
                console.error(error);
            });
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label>
                    Email:
                 </label>

                        <input
                        name="email"
                        placeholder="email"
                        type="text"
                        onChange={this.handleChange}
                         />
                <br />
                <label>
                    Password:
                        <input
                        name="password"
                        placeholder="password"
                        type="text"
                        onChange={this.handleChange}
                        />
                </label>
                <input type="submit" value="Submit" />
            </form>
        );
    }
}

ReactDOM.render(
    <Login />,
    document.getElementById('root')
);
export default Login;