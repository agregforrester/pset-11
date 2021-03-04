import java.util.ArrayList;

public class ProblemSet11 {

    public static void main(String[] args) {

    }

    public ArrayList<String> fizzBuzz(int start, int end) {
        if (start >= end) {
            return null;
        } else {
            ArrayList<String> arr = new ArrayList<>();

            for(int i = start; i < end; i++) {
                if(i % 15 == 0) {
                    arr.add("FizzBuzz");
                } else if(i % 3 == 0) {
                    arr.add("Fizz");
                } else if(i % 5 == 0) {
                    arr.add("Buzz");
                } else {
                    arr.add(String.valueOf(i));
                }
            }

            return arr;
        }
    }

    public int maxSpan(ArrayList<Integer> numbers) {
        if (numbers == null) {
            return -1;
        } else {
            int max = 0;

            for(int i = 0; i < numbers.size(); i++) {
                int j = numbers.size() - 1;

                while(!numbers.get(i).equals(numbers.get(j)))
                    j--;

                int span = j - i + 1;

                if(span > max)
                    max = span;
            }

            return max;
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
            int i = 0;

            while(i < numbers.size() && numbers.get(i) != 3)
                i++;

            int j = i + 1;

            while(j < numbers.size() && numbers.get(j) != 4)
                j++;

            while(i < numbers.size()) {
                if(numbers.get(i) == 3) {
                    int temp = numbers.get(i + 1);
                    numbers.set(i + 1, j);
                    numbers.set(j, temp);

                    while(j < numbers.size() && numbers.get(j) != 4)
                        j++;
                }
                i++;
            }

            return numbers;
        }
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
            int i = 0;
            int j = 0;

            while(j < numbers.size() && numbers.get(j) != 5)
                j++;

            while(i < numbers.size()) {
                if(numbers.get(i) == 4) {
                    int temp = numbers.get(i + 1);
                    numbers.set(i + 1, j);
                    numbers.set(j, temp);

                    while((j < numbers.size() && numbers.get(j) != 5) || j == i + 1)
                        j++;
                }
                i++;
            }

            return numbers;
        }
    }

    public boolean canBalance(ArrayList<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) {
            return false;
        } else {
            int first = 0;
            int second = 0;

            for (int i = 0; i < numbers.size(); i++)
                second += numbers.get(i);

            for (int i = 0; i <= numbers.size() - 2; i++) {
                first += numbers.get(i);
                second -= numbers.get(i);

                if (first == second)
                    return true;
            }

            return false;
        }
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

        int i = 0;
        int j = 0;

        while(i < inner.size() && j < outer.size()) {
            if(inner.get(i) > outer.get(j)) {
                j++;
            } else if(inner.get(i) < outer.get(j)) {
                return false;
            } else {
                i++;
            }
        }

        if(i != inner.size())
            return false;

        return true;

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
