(ns overtone.jna-path
  (:require [overtone.helpers.system :refer [get-os]]))

;; set jna.library.path to point to native libraries
;; dependant on OS. No path merge to prevent clj-native
;; from pulling out third party lib files from path
(defonce __SET_JNA_PATH__
  (case (get-os)
    :linux (System/setProperty "jna.library.path" "./native/linux")
    :windows (System/setProperty "jna.library.path" "./native/windows")))
