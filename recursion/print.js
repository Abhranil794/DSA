function printtill(a) {
  if (a === 0 || a <= 0) {
    return;
  }
  console.log(a);
  printtill(--a);
}

printtill(5);
