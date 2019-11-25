(ns excelman.xlsx
  (:require  [dk.ative.docjure.spreadsheet :as spreadsheet])
  (:gen-class))

(defn read-row-seq 
  "given a source file and sheet name, reads an xls/xlsx file, returns lazy-seq of the rows 
   consisting of xml fragments of Apache POI objects. https://poi.apache.org/"
  [{:keys [source sheet]}]
  (->> (spreadsheet/load-workbook source)
       (spreadsheet/select-sheet sheet)
       spreadsheet/row-seq))

(defn read-columns
  "given a source file, sheet name, and a map of columns 
   like {:A :item :B :price}, reads an xls/xlsx file, returns  
   a clojure map of the data"
  [{:keys [source sheet cols]}]
  (->> (spreadsheet/load-workbook source)
       (spreadsheet/select-sheet sheet)
       (spreadsheet/select-columns cols)))



