(ns launchpad-clj.core
  (:import [org.rjung.util.launchpad
            Launchpad
            LaunchpadReceiver
            Pad
            Color
            Channel]))

(defonce lp (Launchpad.))

(defn- ch-to-java
 "Converts a kw channel into a java enum channel"
 [ch]
  (get {:ch-1 Channel/C1
        :ch-2 Channel/C2
        :ch-3 Channel/C3
        :ch-4 Channel/C4
        :ch-5 Channel/C5
        :ch-6 Channel/C6
        :ch-7 Channel/C7
        :ch-8 Channel/C8
        :ch-9 Channel/C9
        :ch-10 Channel/C10
        :ch-11 Channel/C11
        :ch-12 Channel/C12
        :ch-13 Channel/C13
        :ch-14 Channel/C14
        :ch-15 Channel/C15
        :ch-16 Channel/C16} ch nil))
(defn- color-to-java
  "Converts a channel from kw form to java enum"
  [color]
  (get {:r0g0 Color/R0G0
        :r1g0 Color/R1G0
        :r2g0 Color/R2G0
        :r3g0 Color/R3G0
        :r0g1 Color/R0G1
        :r1g1 Color/R1G1
        :r2g1 Color/R2G1
        :r3g1 Color/R3G1
        :r0g2 Color/R0G2
        :r1g2 Color/R1G2
        :r2g2 Color/R2G2
        :r3g2 Color/R3G2
        :r0g3 Color/R0G3
        :r1g3 Color/R1G3
        :r2g3 Color/R2G3
        :r3g3 Color/R3G3} color nil))

(defn- pad-to-java
  "Converts a pad from vector form to java enum"
  [[x y]]
  (Pad/find x y))

(defn make-launchpad
  ([]
   (make-launchpad :ch-1))
  ([ch]
   {:lp-java (Launchpad. (ch-to-java ch))}))

(defn- call-to-java-set [lp ^Pad pad ^Color color]
  (.set lp pad color))

(defn set-light [{lp :lp-java} pad color]
  (call-to-java-set lp (pad-to-java pad) (color-to-java color)))
