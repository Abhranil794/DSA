function printtill(a) {
  if (a === 0 || a <= 0) {
    return;
  }
  printtill(a - 1);
  console.log(a);
}

printtill(5);
