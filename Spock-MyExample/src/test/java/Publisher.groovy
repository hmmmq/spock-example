class Publisher {
    def subscribers = []

    def send(event) {
        subscribers.each {
            try {
                it.receive(event)
            } catch (Exception e) {

            }
        }
    }
}

