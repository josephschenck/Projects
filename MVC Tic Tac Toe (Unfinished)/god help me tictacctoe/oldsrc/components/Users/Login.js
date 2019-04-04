import React, { Component } from 'react';

export class Login extends Component {
  displayName = Login.name

  constructor(props) {
    super(props);
    this.state = { users: [], loading: true };

    fetch('api/users')
      .then(response => response.json())
      .then(data => {
        this.setState({ users: data, loading: false });
      });
  }

  static renderVenueTable(users) {
    return (
      <table className='table'>
        <thead>
          <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Capacity</th>
          </tr>
        </thead>
        <tbody>
          {users.map(users =>
            <tr key={users.Id}>
              <td>{users.Email}</td>
              <td>{users.Role}</td>
            </tr>
          )}
        </tbody>
      </table>
    );
  }

  render() {
    let contents = this.state.loading
      ? <p><em>Loading...</em></p>
      : Login.renderVenueTable(this.state.users);

    return (
      <div>
        <h1>Users</h1>
        <p>These users have upcoming events.</p>
        {contents}
      </div>
    );
  }
}