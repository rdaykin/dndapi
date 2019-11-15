// src/components/skills.js

import React from 'react'

const Character = ({ character }) => {
  return (
    <center>
      <div>
        <h1>{character.name}</h1>
        <div>
          <form>
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
                <td><input type="number" id="strength" placeholder="10"></td>
                <td><input type="number" id="dexterity" placeholder="10"></td>
                <td><input type="number" id="constitution" placeholder="10"></td>
                <td><input type="number" id="intelligence" placeholder="10"></td>
                <td><input type="number" id="wisdom" placeholder="10"></td>
                <td><input type="number" id="charisma" placeholder="10"></td>
              </tr>
            </table>
          </form>
        </div>
      </div>
    </center>
)
};

export default Character
