package com.nuvento.sparkexam.TestQuestionOne.handlefiles

import com.nuvento.sparkexam.handlefiles.ReadData.readFileData
import com.nuvento.sparkexam.handlefiles.Schemas
import com.nuvento.sparkexam.utils.SparkSetup
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class JoinDataTest extends AnyFunSuite with BeforeAndAfter {
  SparkSetup.main(Array.empty[String])
  import SparkSetup.spark.implicits._

  test("Test readFileData function on customer_data.csv must returns 500 lines of data") {
    // Input Data
    val testingData = readFileData[Schemas.customerSchema]("customer_data")

    // Call the function
    val result = testingData.collect().length

    // Expected result
    val expected = 500

    // Compare the result with the expected output
    assert(result == expected)
  }
  test("Test readFileData function customer_data.csv schema") {
    // Input Data
    val testingData = readFileData[Schemas.customerSchema]("customer_data")

    // Call the function
    val result = testingData.schema

    // Expected result
    val expected = StructType(Seq(
      StructField("customerId", StringType, nullable = true),
      StructField("forename", StringType, nullable = true),
      StructField("surname", StringType, nullable = true)
    ))

    // Compare the result with the expected output
    assert(result == expected)
  }


  test("Test readFileData function on account_data.csv must returns 600 lines of data") {
    // Input Data
    val testingData = readFileData[Schemas.accountSchema]("account_data")

    // Call the function
    val result = testingData.collect().length

    // Expected result
    val expected = 600

    // Compare the result with the expected output
    assert(result == expected)
  }
  test("Test readFileData function account_data.csv schema") {
    // Input Data
    val testingData = readFileData[Schemas.accountSchema]("account_data")

    // Call the function
    val result = testingData.schema

    // Expected result
    val expected = StructType(Seq(
      StructField("customerId", StringType, nullable = true),
      StructField("accountId", StringType, nullable = true),
      StructField("balance", IntegerType, nullable = true)
    ))

    // Compare the result with the expected output
    assert(result == expected)
  }


  test("Test readFileData function on address_data.csv must returns 500 lines of data") {
    // Input Data
    val testingData = readFileData[Schemas.addressSchema]("address_data")

    // Call the function
    val result = testingData.collect().length

    // Expected result
    val expected = 500

    // Compare the result with the expected output
    assert(result == expected)
  }
  test("Test readFileData function address_data.csv schema") {
    // Input Data
    val testingData = readFileData[Schemas.addressSchema]("address_data")

    // Call the function
    val result = testingData.schema

    // Expected result
    val expected = StructType(Seq(
      StructField("addressId", StringType, nullable = true),
      StructField("customerId", StringType, nullable = true),
      StructField("address", StringType, nullable = true)
    ))

    // Compare the result with the expected output
    assert(result == expected)
  }
}

