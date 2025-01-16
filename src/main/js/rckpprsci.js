const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
  });
  
  let player1Score = 0;
  let player2Score = 0;
  let currentPlayer = 1;
  
  function playRound() {
    readline.question(`Player ${currentPlayer}, enter your move (rock, paper, scissors): `, (move) => {
      const validMoves = ['rock', 'paper', 'scissors'];
      if (!validMoves.includes(move)) {
        console.log('Invalid move. Please enter rock, paper, or scissors.');
        playRound();
        return;
      }
  
      const computerMove = validMoves[Math.floor(Math.random() * validMoves.length)];
      console.log(`Player ${currentPlayer} chose ${move}`);
      console.log(`Computer chose ${computerMove}`);
  
      if (move === computerMove) {
        console.log("It's a tie!");
      } else if (
        (move === 'rock' && computerMove === 'scissors') ||
        (move === 'paper' && computerMove === 'rock') ||
        (move === 'scissors' && computerMove === 'paper')
      ) {
        console.log(`Player ${currentPlayer} wins this round!`);
        if (currentPlayer === 1) {
          player1Score++;
        } else {
          player2Score++;
        }
      } else {
        console.log('Computer wins this round!');
      }
  
      currentPlayer = currentPlayer === 1 ? 2 : 1;
      playRound();
    });
  }
  
  function gameEnd() {
    console.log(`\nFinal Score:`);
    console.log(`Player 1: ${player1Score}`);
    console.log(`Player 2: ${player2Score}`);
    if (player1Score > player2Score) {
      console.log('Player 1 wins the game!');
    } else if (player2Score > player1Score) {
      console.log('Player 2 wins the game!');
    } else {
      console.log("It's a tie!");
    }
    readline.close();
  }
  
  console.log('Welcome to Rock Paper Scissors!');
  playRound();