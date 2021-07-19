const url = 'http://localhost:8080/P1-A-Rod1308/'

document.getElementById('getDisplayButton').addEventListener('click', displayFunc);

async function displayFunc() {

    let response = await fetch(url + 'app', {credentials: "include"});
    //, {credentials: "include"}

    console.log(response);
    console.log("1");



    if(response.status === 200) { //if the request is successful...
        console.log(response); //just to see what comes back for debug
        console.log("2");

        let data = await response.json(); //get the JSON data from the response, turn it into JS object
       // console.log(data.json());
        console.log("3");
        console.log(data);
       // console.log("4");

        //document.getElementById("tableHeader").style.display = "inline";




        //now, I want to put each avenger into my table
        for(let reimbursment of data) { //for every avenger in the data variable/object

            console.log(reimbursment); //just for debug, print the avenger in the console

             let row = document.createElement("tr"); //create a table row

            let cell = document.createElement("td"); //create a cell for the field
            cell.innerHTML = reimbursment.reimb_id; //fill the cell with avenger data
            cell.className = "idColumn";
            row.appendChild(cell); //this row now has the first cell (av_id)

            let cell2 = document.createElement("td");
            cell2.innerHTML = reimbursment.reimb_amount;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = reimbursment.reimb_submited;
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            cell4.innerHTML = reimbursment.reimb_resolved;
            row.appendChild(cell4);

            let cell5 = document.createElement("td");
            cell5.innerHTML = reimbursment.reimb_description;
            row.appendChild(cell5);

            let cell6 = document.createElement("td");
            cell6.innerHTML = reimbursment.reimb_receipt;
            row.appendChild(cell6);

            let cell7 = document.createElement("td");
            cell7.innerHTML = reimbursment.reimb_author;
            row.appendChild(cell7);

            let cell8 = document.createElement("td");
            cell8.innerHTML = reimbursment.reimb_resolver;
            row.appendChild(cell8);

            let cell9 = document.createElement("td");
            cell9.innerHTML = reimbursment.reimb_status_id;
            row.appendChild(cell9);

            let cell10 = document.createElement("td");
            cell10.innerHTML = reimbursment.reimb_status_id;
            row.appendChild(cell10);

            //if the avenger has a home, just fill the cell with the home name
            // if(avenger.home_fk != null){
            //     console.log("home came through")
            //     let cell7 = document.createElement("td");
            //     cell7.innerHTML = avenger.home_fk.homeName;
            //     row.appendChild(cell7);
            // } else { //otherwise, still append the cell but leave it empty
            //     let cell7 = document.createElement("td");
            //     row.appendChild(cell7);
            // }



             document.getElementById("avengerBody").appendChild(row);
            //so the variable "row" we created alllll the way at the top of the for loop 
            //will be appended to our empty table body in the HTML

        }
///////////////////////
//////////////
///////////////////////////////
////make js list maybe a loop to get all elements and their info 


//////////////////////////
        let idColumnList = document.getElementsByClassName("idColumn");
        let select = document.getElementById("idSelect");
        for(let x of idColumnList){
            console.log(x.innerHTML);

            let option = document.createElement("option");
            option.value=x.innerHTML;
            option.innerHTML=x.innerHTML;
            select.appendChild(option);
        }

        
       

    }
    



}