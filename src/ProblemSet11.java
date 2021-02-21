import java.util.ArrayList;

public class ProblemSet11 {

    public static void main(String[] args) {

    }

    public ArrayList<String> fizzBuzz(int start, int end) {
        if (start >= end) {
            return null;
        } else {
            ArrayList<String> newArray = new ArrayList<>();
            int index = 0;
            String k;
            for (int i = start; i < end; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    newArray.add(index, "FizzBuzz");
                } else if (i % 3 == 0) {
                    newArray.add(index, "Fizz");
                } else if (i % 5 == 0) {
                    newArray.add(index, "Buzz");
                } else {
                    k = Integer.toString(i);
                    newArray.add(k);
                }

                index++;
            }

            return newArray;
        }
    }

    public int maxSpan(ArrayList<Integer> numbers) {
        if (numbers == null) {
            return -1;
        } else {
            int x;
            int span;
            int result = 0;

            for (int number : numbers) {
                if (numbers.size() == 1) {
                    result = 1;
                } else {
                    x = number;
                    for (int i = numbers.size() - 1; i >= 0; i--) {
                        if (numbers.get(i) == x) {
                            span = i;
                            if (span > result) {
                                result = span;
                            }
                        }
                    }
                }
            }

            return result;
        }
    }

    public ArrayList<Integer> fix34(ArrayList<Integer> numbers) {
        int counter3 = 0;
        int counter4 = 0;
        if (numbers == null) {
            return null;
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == 3) {
                counter3++;
                if (i > 0 && numbers.get(i - 1) == 3) {
                    return null;
                }
            } else if (numbers.get(i) == 4) {
                counter4++;
            }

            if (counter4 == 1 && counter3 == 0) {
                return null;
            }
        }

        if (counter3 != counter4) {
            return null;
        } else {
            int x;
            for (int j = 0; j < numbers.size(); j++) {
                if (numbers.get(j) == 3) {
                    for (int k = j + 2; k < numbers.size(); k++) {
                        if (numbers.get(k) == 4) {
                            x = numbers.get(k);
                            numbers.set(k, numbers.get(j + 1));
                            numbers.set(j + 1, x);
                        }
                    }

                    for (int a = 0; a < numbers.size() - 1; a++) {
                        if (numbers.get(a) == 3 && numbers.get(a + 1) != 4) {
                            int z;
                            for (int b = 0; b < numbers.size(); b++) {
                                if (numbers.get(b) == 4) {
                                    z = numbers.get(b);
                                    numbers.set(b, numbers.get(a + 1));
                                    numbers.set(a + 1, z);
                                }
                            }
                        }
                    }
                }
            }
        }
        return numbers;
    }

    public ArrayList<Integer> fix45(ArrayList<Integer> numbers) {
        int counter4 = 0;
        int counter5 = 0;
        if (numbers == null) {
            return null;
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == 4) {
                counter4++;
                if (i > 0 && numbers.get(i - 1) == 4) {
                    return null;
                }
            } else if (numbers.get(i) == 5) {
                counter5++;
            }
        }

        if (counter4 != counter5) {
            return null;
        } else {
            int x;
            for (int j = 0; j < numbers.size(); j++) {
                if (numbers.get(j) == 4) {
                    for (int k = j + 2; k < numbers.size(); k++) {
                        if (numbers.get(k) == 5) {
                            x = numbers.get(k);
                            numbers.set(k, numbers.get(j + 1));
                            numbers.set(j + 1, x);
                        }
                    }

                    for (int a = 0; a < numbers.size() - 1; a++) {
                        if (numbers.get(a) == 4 && numbers.get(a + 1) != 5) {
                            int z;
                            for (int b = 0; b < numbers.size(); b++) {
                                if (numbers.get(b) == 5) {
                                    z = numbers.get(b);
                                    numbers.set(b, numbers.get(a + 1));
                                    numbers.set(a + 1, z);
                                }
                            }
                        }
                    }
                }
            }
        }
        return numbers;
    }

    public boolean canBalance(ArrayList<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) {
            return false;
        } else {
            int firstSum = 0;
            int secondSum= 0;
            for (int i = 0; i < numbers.size(); i++) {
                if (i == 0) {
                    firstSum = numbers.get(i);
                    for (int k = 1; k < numbers.size(); k++) {
                        secondSum = numbers.get(k);
                    }

                    if (firstSum == secondSum) {
                        return true;
                    } else {
                        firstSum = 0;
                        secondSum = 0;
                    }

                } else {
                    for (int j = 0; j <= i; j++) {
                        firstSum += numbers.get(j);
                    }

                    for (int h = i + 1; h < numbers.size(); h++) {
                        secondSum += numbers.get(h);
                    }

                    if (firstSum == secondSum) {
                        return true;
                    } else {
                        firstSum = 0;
                        secondSum = 0;
                    }
                }

            }
        }
        return false;
    }

    public boolean linearIn(ArrayList<Integer> outer, ArrayList<Integer> inner) {
        if (outer == null || inner == null || outer.size() == 0 || inner.size() == 0) {
            return false;
        }

        for (int a = 1; a < outer.size(); a++) {
            if (outer.get(a) < outer.get(a - 1)) {
                return false;
            }
        }

        for (int b = 1; b < inner.size(); b++) {
            if (inner.get(b) < inner.get(b - 1)) {
                return false;
            }
        }

        int counter = 0;
        for (int j : inner) {
            for (int k : outer) {
                if (k == j) {
                    counter++;
                }
            }
        }

        return counter >= inner.size();

    }

    public ArrayList<Integer> squareUp(int n) {
        ArrayList<Integer> arr = new ArrayList<>();

        if(n == 0)
            return arr;

        for(int i = n - 1; i < n * n; i += n) {
            for(int j = i; j >= i - i / n; j--)
                arr.set(j, i - j + 1);
        }

        return arr;
    }

    public ArrayList<Integer> seriesUp(int n) {
        ArrayList<Integer> arr = new ArrayList<>();

        int index = 0;

        for (int k = 0; k < n*(n+1)/2; k++) {
            arr.add(0);
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                arr.set(index + j, j + 1);
            }
            index += i;
        }

        return arr;
    }

    public int maxMirror(ArrayList<Integer> numbers) {
        int max = 0;

        for(int i = 0; i < numbers.size(); i++) {
            int count = 0;
            for(int j = numbers.size() - 1; j >= 0 && i + count < numbers.size(); j--) {
                if(numbers.get(i + count) == numbers.get(j)) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 0;
                }
            }

            max = Math.max(max, count);
        }

        return max;
    }

    public int countClumps(ArrayList<Integer> numbers) {
        int count = 0;
        int i = 0;

        while(i < numbers.size()) {
            int val = numbers.get(i);
            i++;
            int length = 1;
            while(i < numbers.size() && numbers.get(i) == val) {
                i++;
                length++;
            }

            if(length > 1)
                count++;
        }

        return count;
    }
}
