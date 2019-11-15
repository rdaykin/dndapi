// src/components/skills.js

import React from 'react'

const Character = ({ character }) => {
  return (
    <center>
      <div>
        <h1>{character.name}</h1>
        <div>
          <table class="table table-bordered table-condensed">
            <tr>
              <th>STR</th>
              <th>DEX</th>
              <th>CON</th>
              <th>INT</th>
              <th>WIS</th>
              <th>CHA</th>
            </tr>
            <tr>
              <td>{character.strength}</td>
              <td>{character.dexterity}</td>
              <td>{character.constitution}</td>
              <td>{character.intelligence}</td>
              <td>{character.wisdom}</td>
              <td>{character.charisma}</td>
            </tr>
          </table>
          <p class="card-text">{character.governingStat}</p>
        </div>
      </div>
    </center>
)
};

export default Character
