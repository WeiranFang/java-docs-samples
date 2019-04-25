/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.language.automl.sentiment.analysis.samples;

// [START automl_natural_language_sentiment_get_dataset]
import com.google.cloud.automl.v1beta1.AutoMlClient;
import com.google.cloud.automl.v1beta1.Dataset;
import com.google.cloud.automl.v1beta1.DatasetName;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

class GetDataset {

  // Get a given dataset
  static void getDataset(String projectId, String computeRegion, String datasetId)
      throws IOException {
    // String projectId = "YOUR_PROJECT_ID";
    // String computeRegion = "YOUR_COMPUTE_REGION";
    // String datasetId = "YOUR_DATASET_ID";

    // Instantiates a client
    AutoMlClient client = AutoMlClient.create();

    // Get the complete path of the dataset.
    DatasetName datasetFullId = DatasetName.of(projectId, computeRegion, datasetId);

    // Get all the information about a given dataset.
    Dataset dataset = client.getDataset(datasetFullId);

    client.close();

    // Display the dataset information.
    System.out.println(String.format("Dataset name: %s", dataset.getName()));
    System.out.println(
        String.format(
            "Dataset Id: %s",
            dataset.getName().split("/")[dataset.getName().split("/").length - 1]));
    System.out.println(String.format("Dataset display name: %s", dataset.getDisplayName()));
    System.out.println("Text sentiment dataset metadata:");
    System.out.print(String.format("\t%s", dataset.getTextSentimentDatasetMetadata()));
    System.out.println(String.format("Dataset example count: %d", dataset.getExampleCount()));
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    String createTime =
        dateFormat.format(new java.util.Date(dataset.getCreateTime().getSeconds() * 1000));
    System.out.println(String.format("Dataset create time: %s", createTime));
  }
}
// [END automl_natural_language_sentiment_get_dataset]