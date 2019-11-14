// src/components/skills.js

import React from 'react'

const Skills = ({ skills }) => {
  console.log("HELLO")
  return (
    <div>
      <center><h1>Skill List</h1></center>
      {skills.map((skill) => (
        <div>
          <h2 class="card-title">{skill.name}</h2>
          <h3 class="card-subtitle mb-2 text-muted">{skill.id}</h3>
          <p class="card-text">{skill.governingStat}</p>
        </div>
      ))}
    </div>
  )
};

export default Skills
