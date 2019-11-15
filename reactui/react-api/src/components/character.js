// src/components/skills.js

import React from 'react'

const Character = ({ character }) => {
  return (
    <center>
      <div>
        <h1>{character.name}</h1>
        <div>
          <table className="table table-bordered table-condensed">
            <thead>
              <tr>
                <th><strong>STR</strong></th>
                <th><strong>DEX</strong></th>
                <th><strong>CON</strong></th>
                <th><strong>INT</strong></th>
                <th><strong>WIS</strong></th>
                <th><strong>CHA</strong></th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>{character.strength}</td>
                <td>{character.dexterity}</td>
                <td>{character.constitution}</td>
                <td>{character.intelligence}</td>
                <td>{character.wisdom}</td>
                <td>{character.charisma}</td>
              </tr>
            </tbody>
          </table>
          <p className="card-text">{character.governingStat}</p>
        </div>
      </div>
    </center>
)
};

export default Character
