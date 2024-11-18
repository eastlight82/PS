let i1=read_line () in
let i2=read_line () in
let i3=read_line () in

let i4= match i3 with 
    |"Fizz"-> (match i2 with
        |"Buzz"-> string_of_int ((int_of_string i1)+3)
        |_-> let b=int_of_string i2 in
            if (b+2) mod 5=0 then "Buzz" 
            else string_of_int (b+2))

    |"Buzz"-> if i1="Fizz" then "Fizz" else string_of_int ((int_of_string i1)+3)
    |"FizzBuzz"-> string_of_int ((int_of_string i2)+2)
    |_-> let a=int_of_string i3 in 
        if (a+1) mod 3=0 
            then (if (a+1) mod 5=0 then "FizzBuzz" else "Fizz") 
        else (if (a+1) mod 5=0 then "Buzz" else string_of_int (a+1)) in

print_endline i4;