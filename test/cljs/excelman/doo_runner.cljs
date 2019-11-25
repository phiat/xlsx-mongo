(ns excelman.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [excelman.core-test]))

(doo-tests 'excelman.core-test)

