# BankModule
#BankModule SpringBoot and MicroServices project

Post: http://localhost:9096/bank/savebanks

      {
        "bankName": "SBI",
        "bankIfscCode": "SBIN0000001",
        "bankBranchAddress": "SP",
        "bankPoolingAccountNumber": "00001234501"
}

      {
        "bankName": "ICICI",
        "bankIfscCode": "ICIC0000002",
        "bankBranchAddress": "ADIBATLA",
        "bankPoolingAccountNumber": "00001234502"
   }
     {
        "bankName": "CITI",
        "bankIfscCode": "CITI0000003",
        "bankBranchAddress": "HiTech",
        "bankPoolingAccountNumber": "00001234503"
    }

==============
get : http://localhost:9096/bank/getAllBanks

[
    {
        "bankId": 29,
        "bankName": "SBI",
        "bankIfscCode": "SBIN0000001",
        "bankBranchAddress": "SP",
        "bankPoolingAccountNumber": "00001234501"
    },
    {
        "bankId": 30,
        "bankName": "ICICI",
        "bankIfscCode": "ICIC0000002",
        "bankBranchAddress": "ADIBATLA",
        "bankPoolingAccountNumber": "00001234502"
    },
    {
        "bankId": 31,
        "bankName": "CITI",
        "bankIfscCode": "CITI0000003",
        "bankBranchAddress": "HiTech",
        "bankPoolingAccountNumber": "00001234503"
    }
]

=================

Put: http://localhost:9096/bank/updatebankdetails/29

{
        "bankId": 29,
        "bankName": "SBI",
        "bankIfscCode": "SBIN0000001",
        "bankBranchAddress": "SP",
        "bankPoolingAccountNumber": "00001234501"
    }
