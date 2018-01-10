export function fetchTeamMembers() {
  return new Promise(res => {
    setTimeout(() => {
      res([
        {
          id: 1,
          name: "Bras Gauche",
        },
        {
          id: 2,
          name: "Jambe Droite",
        },
        {
          id: 4,
          name: "Bras Droit",
        },
        {
          id: 8,
          name: "Jambe Gauche",
        },
      ])
    }, 2000);
  })
}
